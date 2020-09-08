# MOHON DIPERHATIKAN unguided-android

*TODO 1.1(5) -> file styles.xml*
- Melakukan perubahan parent MaterialComponent

*TODO 1.2(2,5) -> file strings.xml*
- Mengubah XXXX menjadi NPM masing-masing

*TODO 2.1(5) -> file activity_main.xml*
- Menjelaskan maksud dari layout recyclerview, langsung dikerjakan disini ya.
- Jawaban : id merupakan identitas dari recyclerview, list item merupakan bagian akan berulang pada recycler view tersebut. Pada code ini list item merujuk pada item_receipt. **yang wajib dijelaskan adalah id dan list item**

*TODO 2.2(2,5) -> file item_receipt.xml*
- Apa yang kamu ketahui tentang MaterialCardView dan fitur-fiturnya?
- Jawaban : MaterialCardView adalah card view yang telah disediakan oleh material design dan mempunyai beberapa fitur. Terdapat clickable, checkable dan focusable. Clickable berarti bisa di click, checkable bisa di check, dan focusable akan menjadi focus jika merujuk pada card tersebut. Pada kali ini menggunakan fitur checkable.

*TODO 3 -> file ReceiptRecyclerViewAdapter*
- TODO 3.1(2,5)
  - Membuat variabel penampung untuk title receipt yang "checked"
- TODO 3.2(5)
  - Membuat fungsi yang mengembalikan list title receipt yang "checked"
- TODO 3.3(10)
  - Membuat fungsi untuk menambahkan title receipt yang checked dan menghapus yang unchecked
- TODO 3.4(2,5)
  - Fungsi untuk menambah ataupun menghapus dipanggil disini

*TODO 4 -> file ActivityMain*
- TODO 4.1(2,5)
  - Melakukan inisialisasi "checked" yang didapat dari fungsi yang berada pada recyclerViewAdapter
- TODO 4.2(10)
  - Menampilkan simple dialog yang menampilkan title receipt yang checked
- TODO 4.3(5)
  - Apa maksud fungsi ini ? (2 kalimat)
  - Jawaban : Fungsi untuk merubah list menjadi array of string. Pada adapter menggunakan list supaya mudah add dan remove, tampilnya pada dialog harus array of string.
- TODO 4.4(2,5)
  - Fungsi menampilkan dialog dipanggil disini

*TODO 5 -> file Receipt*
- TODO 5.1 (5)
  - Apa perbedaan dua construtor berikut ? (Jawab dgn 2 kalimat)
  - Jawaban : Perbedaan pada parameter, dimana yang satu tanpa parameter dan yang kedua dengan parameter. Penggunaan yang pertama lebih fleksibel karena pembuatan object bisa saja tanpa nilai terlebih dahulu.

***Total UGD 60 (tanpa bonus)***

**KETERANGAN**
- [x] Wajib menggunakan material design

**MINUS POINT**
- [x] Pada nomor 2, jika tidak melakukan first commit setelah clone, maka nilai –2,5
- [x] Jika terdapat penggunaan string hardcode maka nilai –2,5

