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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val materiList = listOf(
            Materi(getString(R.string.materi_01_num), getString(R.string.materi_01_title), getString(R.string.materi_01_desc),
                "Android Studio adalah Integrated Development Environment (IDE) resmi untuk membuat, menjalankan, dan menguji aplikasi Android berbasis Kotlin.",
                listOf("Struktur project: AndroidManifest.xml, kode Kotlin, dan folder res.", "Gradle mengatur SDK, dependency, serta proses build aplikasi.", "AVD dan perangkat fisik digunakan untuk menjalankan serta melakukan debugging aplikasi."),
                "Mahasiswa membuat project Android baru, mengenali area kerja Android Studio, lalu menjalankan aplikasi pada emulator atau perangkat fisik.",
                "Pemahaman struktur project dan proses build menjadi dasar sebelum merancang layout maupun menulis logika aplikasi.", R.drawable.android_studio),
            Materi(getString(R.string.materi_02_num), getString(R.string.materi_02_title), getString(R.string.materi_02_desc),
                "LinearLayout adalah ViewGroup yang menyusun View anak dalam satu arah, yaitu vertikal atau horizontal.",
                listOf("android:orientation menentukan susunan vertical atau horizontal.", "android:layout_weight membagi sisa ruang secara proporsional.", "gravity dan layout_gravity membantu mengatur perataan konten."),
                "Mahasiswa menyusun formulir secara vertikal, deretan tombol secara horizontal, dan membagi ukuran kolom menggunakan weight.",
                "LinearLayout cocok untuk susunan sederhana satu dimensi; nesting yang berlebihan sebaiknya dihindari.", R.drawable.linear_layout),
            Materi(getString(R.string.materi_03_num), getString(R.string.materi_03_title), getString(R.string.materi_03_desc),
                "RelativeLayout memosisikan View berdasarkan View lain atau batas parent sehingga susunan layar dapat mengikuti hubungan antar komponen.",
                listOf("Aturan seperti layout_below dan layout_toEndOf mengatur posisi relatif antar View.", "alignParentTop, alignParentEnd, dan centerInParent memosisikan View terhadap parent.", "Aturan posisi perlu dijaga tetap jelas agar layout mudah dirawat."),
                "Mahasiswa menyusun layar sederhana dengan komponen yang berada di bawah, di samping, atau di tengah komponen lain.",
                "RelativeLayout menunjukkan cara membangun hubungan posisi antar View dan terhadap parent.", R.drawable.relative_constraint_layout),
            Materi(getString(R.string.materi_04_num), getString(R.string.materi_04_title), getString(R.string.materi_04_desc),
                "ConstraintLayout adalah layout fleksibel yang menempatkan View menggunakan constraint terhadap parent atau View lain.",
                listOf("Constraint start, end, top, dan bottom membentuk hubungan posisi yang jelas.", "Bias membantu mengatur posisi View di antara dua constraint.", "Guideline dan barrier dapat digunakan saat layout membutuhkan aturan responsif."),
                "Mahasiswa membuat layout dengan constraint agar komponen tetap tersusun baik pada beragam ukuran layar.",
                "ConstraintLayout membantu menghasilkan hierarki layout yang lebih datar dan responsif untuk tampilan kompleks.", R.drawable.relative_constraint_layout),
            Materi(getString(R.string.materi_05_num), getString(R.string.materi_05_title), getString(R.string.materi_05_desc),
                "Activity adalah satu layar dalam aplikasi Android. Intent digunakan untuk berpindah antar Activity dan membawa data bila diperlukan.",
                listOf("Lifecycle Activity mencakup onCreate, onStart, onResume, onPause, onStop, dan onDestroy.", "Explicit Intent digunakan untuk membuka Activity tertentu di dalam aplikasi.", "Implicit Intent meminta sistem menjalankan aksi umum melalui aplikasi yang sesuai.", "putExtra dan getStringExtra digunakan untuk mengirim serta membaca data."),
                "Mahasiswa membuat Activity kedua, membuka halaman tersebut dengan Intent eksplisit, dan mengirim data dari halaman sebelumnya.",
                "Activity dan Intent membentuk dasar navigasi serta pertukaran data pada aplikasi Android multi-halaman.", R.drawable.activity_intent),
            Materi(getString(R.string.materi_06_num), getString(R.string.materi_06_title), getString(R.string.materi_06_desc),
                "Spinner, DatePicker, TimePicker, dan Dialog adalah komponen Android untuk memilih data serta memberi umpan balik kepada pengguna.",
                listOf("Spinner menampilkan daftar pilihan dalam bentuk dropdown.", "DatePickerDialog dan TimePickerDialog digunakan untuk memilih tanggal dan waktu.", "AlertDialog menampilkan informasi, konfirmasi, atau pilihan tindakan.", "Listener seperti setOnItemSelectedListener dan setOnClickListener menangani interaksi pengguna."),
                "Mahasiswa membuat form yang memakai Spinner, pemilih tanggal dan waktu, lalu menampilkan dialog sesuai tindakan pengguna.",
                "Komponen input standar membantu membuat interaksi yang jelas tanpa membuat kontrol antarmuka dari awal.", R.drawable.ui_component),
            Materi(getString(R.string.materi_07_num), getString(R.string.materi_07_title), getString(R.string.materi_07_desc),
                "Modul ini membahas Custom Style, Options Menu, Fragment, ViewPager2, FragmentStateAdapter, serta TabLayout untuk membangun aplikasi yang konsisten dan mudah dinavigasi.",
                listOf("Custom Style menyimpan pola tampilan berulang di styles.xml.", "Options Menu dibuat dari resource menu XML, di-inflate pada onCreateOptionsMenu, lalu ditangani lewat onOptionsItemSelected.", "Fragment membagi layar menjadi bagian modular dengan siklus hidupnya sendiri.", "ViewPager2, FragmentStateAdapter, TabLayout, dan TabLayoutMediator membentuk navigasi tab."),
                "Mahasiswa menerapkan style kustom serta menyatukan Home, Materi, dan Quiz menggunakan Fragment, ViewPager2, TabLayout, dan Options Menu.",
                "Style dan navigasi berbasis tab membuat aplikasi lebih konsisten, modular, serta mudah digunakan.", R.drawable.style_option_menu_tabs)
        )
        binding.rvMateri.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMateri.adapter = MateriAdapter(materiList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
