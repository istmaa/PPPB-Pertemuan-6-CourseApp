package com.example.courseapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.courseapp.databinding.FragmentMateriBinding

class MateriFragment : Fragment() {

    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val materiList = listOf(
            Materi(
                number = getString(R.string.materi_01_num),
                title = getString(R.string.materi_01_title),
                description = getString(R.string.materi_01_desc),
                overview = "Android Studio merupakan Integrated Development Environment (IDE) resmi yang digunakan untuk merancang, membangun, dan menguji aplikasi mobile berbasis Android menggunakan bahasa pemrograman Kotlin.",
                concepts = listOf(
                    "Struktur Proyek Android: Memahami peran folder manifests (AndroidManifest.xml), folder java/kotlin (package kode sumber logika), serta folder res (layout XML, values colors/strings/themes, drawable, dan mipmap).",
                    "Gradle Build System: Mengonfigurasi file build.gradle.kts dan libs.versions.toml untuk mengatur compileSdk, minSdk, targetSdk, dependencies library, dan buildFeatures.",
                    "Device Deployment & Emulasi: Menggunakan Android Virtual Device (AVD) serta physical device melalui Android Debug Bridge (ADB) untuk menjalankan dan debugging aplikasi."
                ),
                practice = "Pada praktikum modul pertama, mahasiswa menginisialisasi project baru, memahami jendela kerja Android Studio, menghubungkan SDK Android, dan menjalankan aplikasi pertama pada emulator Android.",
                summary = "Memahami fondasi arsitektur direktori proyek dan manajemen build Gradle merupakan prasyarat esensial sebelum melangkah ke perancangan layout dan logika aplikasi."
            ),
            Materi(
                number = getString(R.string.materi_02_num),
                title = getString(R.string.materi_02_title),
                description = getString(R.string.materi_02_desc),
                overview = "LinearLayout adalah ViewGroup mendasar dalam Android yang menyusun seluruh View anak secara berurutan dalam satu dimensi linier: vertikal atau horizontal.",
                concepts = listOf(
                    "Orientasi Tata Letak: Menentukan arah susunan elemen menggunakan atribut android:orientation=\"vertical\" (atas ke bawah) atau android:orientation=\"horizontal\" (kiri ke kanan).",
                    "Bobot Tampilan (Layout Weight): Memanfaatkan atribut android:layout_weight dan android:weightSum untuk membagi sisa ruang layar secara proporsional dan responsif.",
                    "Perataan Konten: Mengatur posisi komponen di dalam batasnya menggunakan android:gravity, serta mengatur posisi View terhadap induknya melalui android:layout_gravity."
                ),
                practice = "Penerapan praktikum mencakup pembuatan formulir input terstruktur secara vertikal, penataan deretan tombol horizontal, serta pembagian proporsi kolom form yang dinamis.",
                summary = "LinearLayout sangat efektif dan cepat untuk menyusun antarmuka terstruktur satu dimensi, namun hindari nesting berlebihan untuk menjaga performa rendering antarmuka."
            ),
            Materi(
                number = getString(R.string.materi_03_num),
                title = getString(R.string.materi_03_title),
                description = getString(R.string.materi_03_desc),
                overview = "RelativeLayout dan ConstraintLayout merupakan ViewGroup tingkat lanjut yang memungkinkan penataan antarmuka kompleks dengan memosisikan komponen secara relatif terhadap elemen lain atau terhadap induknya.",
                concepts = listOf(
                    "RelativeLayout: Menentukan posisi komponen menggunakan aturan relasional seperti android:layout_below, android:layout_toEndOf, android:alignParentTop, dan android:centerInParent.",
                    "ConstraintLayout: Layout modern dan fleksibel yang direkomendasikan Google untuk menciptakan struktur tampilan hierarki datar (flat hierarchy) tanpa memerlukan banyak layout bersarang.",
                    "Anchor Constraints & Bias: Menghubungkan titik kait (start, end, top, bottom) antar elemen, mengatur persentase bias posisi, dan memanfaatkan barrier serta guideline untuk responsivitas layar."
                ),
                practice = "Mahasiswa mempraktikkan konversi layout berlapis menjadi satu struktur ConstraintLayout yang rapi, menghasilkan performa rendering yang optimal pada berbagai dimensi layar perangkat.",
                summary = "ConstraintLayout menjadi standar utama dalam perancangan antarmuka Android modern karena fleksibilitasnya dalam menangani desain kompleks dengan efisiensi tinggi."
            ),
            Materi(
                number = getString(R.string.materi_04_num),
                title = getString(R.string.materi_04_title),
                description = getString(R.string.materi_04_desc),
                overview = "Activity mewakili satu layar tunggal dengan antarmuka pengguna dalam aplikasi Android, sedangkan Intent adalah objek perantara yang memfasilitasi komunikasi dan navigasi antar komponen.",
                concepts = listOf(
                    "Activity Lifecycle: Memahami tahapan siklus hidup Activity meliputi onCreate(), onStart(), onResume(), onPause(), onStop(), dan onDestroy() untuk pengelolaan resource memori yang tepat.",
                    "Explicit Intent: Digunakan untuk berpindah secara spesifik dari satu Activity ke Activity lain di dalam aplikasi yang sama (seperti navigasi menuju halaman detail materi ini).",
                    "Implicit Intent: Meminta sistem Android menjalankan aksi umum menggunakan aplikasi eksternal yang sesuai, misalnya membuka tautan web di browser atau melakukan panggilan.",
                    "Pengiriman Data: Mengirimkan parameter data antar halaman menggunakan method intent.putExtra() dan mengambilnya kembali menggunakan intent.getStringExtra() pada Activity tujuan."
                ),
                practice = "Implementasi praktikum mencakup pembuatan Activity kedua, navigasi perpindahan layar dengan Intent eksplisit, serta pengiriman dan penampilan data parameter di halaman tujuan.",
                summary = "Penguasaan siklus hidup Activity dan pertukaran data melalui Intent merupakan pondasi utama dalam menciptakan alur navigasi multi-layar yang andal dan interaktif."
            ),
            Materi(
                number = getString(R.string.materi_05_num),
                title = getString(R.string.materi_05_title),
                description = getString(R.string.materi_05_desc),
                overview = "UI Component mencakup ragam elemen kontrol antarmuka grafis yang disediakan Android SDK untuk menerima interaksi pengguna, menampilkan informasi, dan menyajikan dialog interaktif.",
                concepts = listOf(
                    "Elemen Dasar & Input: Memahami TextView untuk menampilkan teks, EditText untuk input teks pengguna, Button untuk trigger aksi, dan ImageView untuk menampilkan grafik gambar.",
                    "Komponen Pilihan: Mengimplementasikan Spinner untuk dropdown pilihan, CheckBox untuk opsi multi-pilih, serta RadioButton dan RadioGroup untuk opsi tunggal (single-choice).",
                    "Dialog Interaktif: Menampilkan AlertDialog untuk konfirmasi aksi, DatePickerDialog untuk pemilihan tanggal kalender, dan TimePickerDialog untuk pemilihan waktu jam.",
                    "Event Handling: Memasang listener penanganan klik seperti setOnClickListener() dan listener seleksi item setOnItemSelectedListener()."
                ),
                practice = "Mahasiswa membuat formulir pendaftaran interaktif yang menggabungkan input teks, dropdown pilihan kategori, checkbox persetujuan, serta dialog pemilih tanggal.",
                summary = "Kombinasi berbagai komponen UI standar dan penanganan event yang tepat menghasilkan pengalaman pengguna (UX) yang interaktif, intuitif, dan nyaman."
            ),
            Materi(
                number = getString(R.string.materi_06_num),
                title = getString(R.string.materi_06_title),
                description = getString(R.string.materi_06_desc),
                overview = "Materi ini membahas teknik pemolesan antarmuka profesional melalui Custom Style, pembuatan menu navigasi Options Menu, serta modularisasi antarmuka menggunakan Fragment, ViewPager2, dan TabLayout.",
                concepts = listOf(
                    "Custom Style & Drawable Selector: Mendefinisikan gaya tombol bersudut rounded (CustomRoundedButton) pada styles.xml dan selector state (normal dan pressed) pada drawable XML.",
                    "Options Menu pada Toolbar: Mendeklarasikan resource menu XML, meng-inflate pada onCreateOptionsMenu(), dan menangani aksi klik item menu melalui onOptionsItemSelected().",
                    "Fragment Architecture: Menggunakan Fragment sebagai bagian modular dari antarmuka pengguna yang memiliki siklus hidup sendiri dan dapat disematkan di dalam Activity.",
                    "Integrasi ViewPager2 & TabLayout: Menggabungkan ViewPager2, TabLayout, FragmentStateAdapter, dan TabLayoutMediator untuk menghasilkan navigasi tab geser yang mulus."
                ),
                practice = "Pada praktikum terkini, mahasiswa membangun Course App dengan tiga bagian utama (Home, Materi, Quiz) yang disatukan melalui TabLayout dan ViewPager2 secara terintegrasi.",
                summary = "Penerapan style kustom dan navigasi berbasis tab menyajikan tata kelola aplikasi modern yang modular, rapi, dan mudah dinavigasi oleh pengguna."
            )
        )

        binding.rvMateri.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMateri.adapter = MateriAdapter(materiList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
