import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/provinsi")  // Ganti dengan endpoint spesifik dari API publik
    fun getProvinces(): Call<List<Province>>  // Sesuaikan dengan model data yang benar
}
