package fpoly.namth.lab2

fun main () {
    val xe1 = Xehoi("Xe 1", 1000f)
    val xe2 = Xehoi("Xe 2", 1500f, 1996)

    xe1.tenXe += " ten xe moi 2024"

    println(xe1.hienThiThongTinXe())
    println(xe2.hienThiThongTinXe())

    // vi du ve null safety
    val tenSV : String? = "Nguyen The Anh"

    getMssv2(tenSV!!)
}

fun getMssv2 (tenSV: String) {
    if (tenSV == null) {
        println("Ten SV khong duoc null!")
    } else {
        println("Ten SV la: $tenSV")
    }

}

class Xehoi (var tenXe : String, var giaXe: Float){

    var namSX : Int? = null

    constructor( tenXe: String,  giaXe: Float, namSX: Int?) : this(tenXe, giaXe) {
        if (namSX != null)
            this.namSX = namSX
    }

    fun hienThiThongTinXe () : String {
        if (namSX == null || namSX == 0) {
            return "Ten xe: $tenXe , gia xe: $giaXe"
        } else {
            return "Ten xe: $tenXe , gia xe: $giaXe , Nam san xuat: ${namSX!!}"
        }
    }

}