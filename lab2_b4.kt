package fpoly.namth.lab2

fun main() {
    val listSV = mutableListOf<SV>()

    val sv1 = SV("John", "MSSV1", 8.5f, true, 20)
    val sv2 = SV("Alice", "MSSV2", 7.2f, false, 22)
    val sv3 = SV("Bob", "MSSV3", 9.0f, true, 21)
    val sv4 = SV("Emily", "MSSV4", 6.8f, false, 19)
    val sv5 = SV("Mike", "MSSV5", 7.9f, true, 23)

    listSV.addAll(listOf(sv1, sv2, sv3, sv4, sv5))
    while (true) {
        println("----- Quản lý Sinh viên -----")
        println("1. Xem danh sách sinh viên")
        println("2. Thêm sinh viên")
        println("3. Sửa thông tin sinh viên")
        println("4. Xóa sinh viên")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                println("Danh sách sinh viên:")
                for (sv in listSV) {
                    println(sv)
                }
                waitEnterKey()
            }
            2 -> {
                themSV(listSV)
                println("Đã thêm sinh viên thành công.")
                waitEnterKey()
            }
            3 -> {
                print("Nhập MSSV của sinh viên cần sửa: ")
                val mssv = readLine() ?: ""
                suaSV(listSV, mssv)
                waitEnterKey()
            }
            4 -> {
                print("Nhập MSSV của sinh viên cần xóa: ")
                val mssv = readLine() ?: ""
                xoaSV(listSV, mssv)
                waitEnterKey()
            }
            0 -> {
                println("Thoát chương trình.")
                return
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
                waitEnterKey()
            }
        }
        println()
    }
}

fun themSV(listSV: MutableList<SV>) {
    val ten: String
    val mssv: String
    val diemTB: Float
    val daTotNghiep: Boolean
    val tuoi: Int

    println("Thêm thông tin sinh viên:")
    print("Tên SV: ")
    ten = readLine() ?: ""
    print("MSSV: ")
    mssv = readLine() ?: ""
    print("Điểm TB: ")
    diemTB = readLine()?.toFloatOrNull() ?: 0f
    print("Đã tốt nghiệp (true/false): ")
    daTotNghiep = readLine()?.toBoolean() ?: false
    print("Tuổi: ")
    tuoi = readLine()?.toIntOrNull() ?: 0

    val sv = SV(ten, mssv, diemTB, daTotNghiep, tuoi)
    listSV.add(sv)
}

fun suaSV(listSV: MutableList<SV>, mssv: String) {
    val sv = listSV.find { it.MSSV == mssv }
    if (sv != null) {
        println("Sửa thông tin sinh viên:")
        print("Tên SV: ")
        val ten = readLine() ?: ""
        print("Điểm TB: ")
        val diemTB = readLine()?.toFloatOrNull() ?: 0f
        print("Đã tốt nghiệp (true/false): ")
        val daTotNghiep = readLine()?.toBoolean() ?: false
        print("Tuổi: ")
        val tuoi = readLine()?.toIntOrNull() ?: 0

        sv.Ten = ten
        sv.DiemTB = diemTB
        sv.daTotNghiep = daTotNghiep
        sv.tuoi = tuoi

        println("Thông tin sinh viên đã được cập nhật.")
    } else {
        println("Không tìm thấy sinh viên với MSSV: $mssv")
    }
}

fun xoaSV(listSV: MutableList<SV>, mssv: String) {
    val sv = listSV.find { it.MSSV == mssv }
    if (sv != null) {
        listSV.remove(sv)
        println("Đã xóa sinh viên với MSSV: $mssv")
    } else {
        println("Không tìm thấy sinh viên với MSSV: $mssv")
    }
}
fun waitEnterKey() {
    println("Nhấn Enter để tiếp tục...")
    readLine()
}

data class SV(
    var Ten: String,
    val MSSV: String,
    var DiemTB: Float?,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)