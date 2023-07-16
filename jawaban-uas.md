# No 1

| No                                    | Use Case                                                          | Rank   | Ket                   |
| ------------------------------------- | ----------------------------------------------------------------- | ------ | --------------------- |
| Use Case User                         |                                                                   |        |                       |
| 1                                     | User Dapat Membuat Akun (Registrasi)                              | High   | Terimplementasi       |
| 2                                     | User Dapat Melakukan Login                                        | High   | Terimplementasi       |
| 3                                     | User Dapat Melihat Daftar Film                                    | Medium | Terimplementasi       |
| 4                                     | User Dapat Mengubah Profil Akun                                   | Low    | Belum Terimplementasi |
| 5                                     | User Dapat Memilih Paket Langganan                                | High   | Belum Terimplementasi |
| 6                                     | User Dapat Melihat Detail Film                                    | Medium | Terimplementasi       |
| 7                                     | User Dapat Memutar FIlm                                           | High   | Belum Terimplementasi |
| 8                                     | User Dapat Memilih Subtitle                                       | Medium | Belum Terimplementasi |
| 9                                     | User Dapat Mengatur Volume FIlm                                   | Medium | Belum Terimplementasi |
| 10                                    | User Dapat Memilih Resolusi Pemutaran                             | Medium | Belum Terimplementasi |
| 11                                    | User Dapat Menjeda Pemutaran FIlm                                 | High   | Belum Terimplementasi |
| 12                                    | User Dapat Menghentikan Pemutaran                                 | High   | Belum Terimplementasi |
| 13                                    | User Dapat Kembali ke Halaman Utama                               | Medium | Terimplementasi       |
| 14                                    | User Dapat Logout dari Akun                                       | High   | Terimplementasi       |
| 15                                    | User Dapat Keluar dari Aplikasi                                   | High   | Terimplementasi       |
| Use Case Manajemen Perusahaan (Admin) |                                                                   |        |                       |
| 16                                    | Admin Dapat Melakukan Login dengan akun admin                     | High   | Terimplementasi       |
| 17                                    | Admin Dapat Masuk ke Halaman Admin                                | High   | Terimplementasi       |
| 18                                    | Admin Dapat Melihat List User                                     | Medium | Terimplementasi       |
| 19                                    | Admin Dapat Merubah Data User                                     | Medium | Belum Terimplementasi |
| 20                                    | Admin Dapat Menghapus User                                        | Low    | Terimplementasi       |
| 21                                    | Admin Dapat Merubah Data Film                                     | Medium | Belum Terimplementasi |
| 22                                    | Admin Dapat Menambah Film                                         | Medium | Terimplementasi       |
| 23                                    | Admin Dapat Menghapus Film                                        | Medium | Terimplementasi       |
| 24                                    | Admin Dapat Logout dari Akun Admin                                | Medium | Terimplementasi       |
| Use Case DIreksi Perusahaan           |                                                                   |        |                       |
| 25                                    | Direksi Dapat Masuk ke halaman data mengenai aplikasi             | High   | Belum Terimplementasi |
| 26                                    | DIreksi Dapat Melihat Statistik Jumlah Pelanggan Aplikasi         | High   | belum Terimplementasi |
| 27                                    | Direksi Dapat Melihat Statisitk Pemasukan dari Langganan Pengguna | High   | Belum Terimplementasi |
| 28                                    | Direksi Dapat Melihat Statistik Waktu Tonton Suatu FIlm           | Medium | Belum Terimplementasi |

# No 2
Class Diagram  

![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/ClassDiagram.jpeg)

# No 3
Mampu menunjukkan dan menjelaskan penerapan setiap poin dari SOLID Design Principle


Menerapkan Single Responsibility Principle (S dari SOLID) pada 3 class berikut, sebelumnya seluruh class dijadikan satu dan hanya ada class ImageProcessor. Tetapi karena terdapat beberapa method yang memiliki fungsi yang berbeda maka dipisah dan dijadikan class baru berdasarkan dengan tugasnya.    
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/SRP-Solid.png)  
Contoh code ini adalah untuk meremove image ketika menghapus entry film, class ImageRemover hanya bertugas untuk meremove image dan tidak ada tugas lain sesuai kaidah SRP   
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/SRP-Solid-Example.png)
![]()


# No 4
Mampu menunjukkan dan menjelaskan Design Pattern yang dipilih  
Deisgn Pattern yang diterapkan adalah Singleton yaitu dengan contoh code berikut   
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/Singleton.png)


# No 5
Mampu menunjukkan dan menjelaskan konektivitas ke database  
Karena menggunakan webService maka konektivitas ke database melalui perantara web Service dengan. Berikut merupakan code untuk konektivitas antara web service dengan database  
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/connect-database.png)
Dan ss database pada MySQL adalah berikut  
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/DB_connect.png)
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/DB_connect1.png)  

Kemudian untuk menghubungkan antara web service dengan UI atau aplikasi adalah dengan class class pada package ini

![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/APICodeinUI.png)  
dan karena file dari database berbentuk array maka diubah menjadi objek menggunakan class class berikut 
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/APICodeUI2.png)

# No 6

Mampu menunjukkan dan menjelaskan pembuatan web service dan setiap operasi CRUD nya
Web Service yang dibuat menggunakan bahasa TypeScript, web service ini mengelola table akun dan film dari database dan menjadi penghubung database dan program aplikasi (UI). 
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/WebServiceSS.png)



# No 7

Mampu menunjukkan dan menjelaskan Graphical User Interface dari produk digital  

![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/GUI_GIF.gif)  
Aplikasi yang dibuat menggunakan Java with Ant pada dengan JavaSwing sebagai UI nya. APlikasi perantaranya yaitu Apache Netbeans, UI sendiri memiliki format file .form karena menggunakan JForm pada JavaSwing dalam proses mendeasain UI. Contoh hasil GUI yang telah dibuat ada disini  



# No 8

Mampu menunjukkan dan menjelaskan HTTP connection melalui GUI produk digital
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/http%20conecction.png)  

HTTP connection yang digunakan yaitu untuk menyambungkan koneksi dari GUI atau aplikasi ke API Web service sebagai perantara database, HTTP connection ini terpisah tergantung untuk keperluannya. pada gambar diatas HTTP connection untuk mengambil data film dari database. Untuk HTTP connection lain yaitu ada pada class dalam gambar di bawah  
![](https://github.com/RFirdaus21/Netflix-Fek-v2/blob/main/photo%20for%20md/APICodeinUI.png)  
terdapat HTTP connection untuk menghandle login, user, register dan film. HTTP connection yang digynakan juga untuk localhost karena memang web service yang digunakan tersambung dengan server lokal saja.


# No 9

Mampu Mendemonstrsikan produk digitalnya kepada publik dengan cara-cara kreatif melalui video Youtube

link demo : https://youtu.be/3liJDg88gKU
