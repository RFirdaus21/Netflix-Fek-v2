package Content;

import API.FilmApiHandler;
import Helper.ImageProcessor;
import Authentication.Login;
import Model.FilmRequestResponse;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class ListMovie extends javax.swing.JFrame{
    public ListMovie(){
        this.initComponents();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel logoutPanel = this.initLogout();
        JPanel logoPanel = this.initLogo();
        JScrollPane movieScrollPane = this.initMovie();
        
        
        add(logoPanel, BorderLayout.NORTH);
        add(movieScrollPane, BorderLayout.CENTER);
        add(logoutPanel, BorderLayout.SOUTH);
        setSize(700, 330);
        setVisible(true);
    }
    
    private JPanel initLogout() {
        JPanel logoutPanel = new JPanel(new GridBagLayout());
        logoutPanel.setBackground(new java.awt.Color(0, 0, 0));

        JButton logoutButton = new JButton();
        logoutButton.setText("Logout");
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.RED);
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.RED));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 10);

        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Login().setVisible(true);
            }
        });

        logoutPanel.add(logoutButton, gbc);

        return logoutPanel;
    }


    
    private JPanel initLogo(){
        JPanel logoPanel = new JPanel(new GridBagLayout());
        logoPanel.setBackground(new java.awt.Color(0, 0, 0));
        JLabel logo = new JLabel();
        
        String imageName = "logo-text.png";
        int imageWidth = 300;
        int imageHeight = 50;
        
        ImageIcon logoImage = ImageProcessor.getInstance().scaleImage(logo, imageName, imageWidth, imageHeight);
        logo.setIcon(logoImage);
        logoPanel.add(logo);
        
        return logoPanel;
    }
    
    private JScrollPane initMovie(){
            FilmApiHandler api = new FilmApiHandler();
            List<FilmRequestResponse> films = api.getAll();

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(new LineBorder(Color.BLACK));
            panel.setBackground(new java.awt.Color(0, 0, 0));
            
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new Insets(10, 10, 10, 10);
            
            int imageWidth = 100;
            int imageHeight = 150;
            int indexIterationMovie = 0;
            String filmTitle;
            String filmImageName;
            int filmYear;
            
            for (FilmRequestResponse film : films) {
                JLabel movie = new JLabel();
                movie.setPreferredSize(new java.awt.Dimension(120, 180));
                
                int filmId = film.getId();
                filmTitle = film.getTitle();
                filmImageName = film.getImage();
                filmYear = film.getYear();
                
                movie.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(movie);
                        frame.dispose();
                        new DetailMovie(filmId).setVisible(true);
                    }
                });

                Font currentFont = movie.getFont();
                Font changedFontSize = currentFont.deriveFont(10f);
                ImageIcon filmImage = ImageProcessor.getInstance().scaleImage(movie, filmImageName, imageWidth, imageHeight);
                
                movie.setIcon(filmImage);
                movie.setText("<html><center>" + filmTitle + " (" + filmYear + ")</center></html>");
                movie.setVerticalTextPosition(JLabel.BOTTOM);
                movie.setHorizontalTextPosition(JLabel.CENTER);
                movie.setFont(changedFontSize);

                if (indexIterationMovie > 0 && indexIterationMovie % 4 == 0) {
                    gridBagConstraints.gridy++;
                    gridBagConstraints.gridx = 0;
                }
                
                panel.add(movie, gridBagConstraints);
            
                gridBagConstraints.gridx++;
                indexIterationMovie++;
            }

            return scrollPane;
    }
}
