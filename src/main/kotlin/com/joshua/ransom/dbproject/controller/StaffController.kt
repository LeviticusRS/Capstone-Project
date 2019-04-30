package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Staff
import com.joshua.ransom.dbproject.repository.StaffRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/staff")
class StaffController {

    @Autowired
    lateinit var staffRepository: StaffRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("07-01-1996").time
        staffRepository.save(Staff("Joshua", "1619 philadelphus rd", "Pembroke", "NC", "28372", "9103746219", "joshua.ransom@uncp.edu", "222-22-2222", 'M', Date(timestamp)))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("04-03-1990").time
        staffRepository.save(Staff("Zion", "1519 philadelphus rd", "Texas", "TX", "28333", "1933462142", "zionhomes@texas.edu", "445-22-1356", 'F', Date(timestamp)))
        return "Done - Staff"
    }

    @RequestMapping("/findAllStaff")
    fun findAll(): Iterable<Staff> = staffRepository.findAll()

    @RequestMapping("/deleteStaffById/{id}")
    fun deleteStaffById(@PathVariable id: Long) = staffRepository.deleteById(id)

    @RequestMapping("/findByStaffName/{staffName}")
    fun findByStaffName(@PathVariable staffName: String) = staffRepository.findByStaffName(staffName)

    @RequestMapping("/new", method = [RequestMethod.POST])
    fun createActor(@RequestParam(value = "staffName") staffName: String,
                    @RequestParam(value = "staffStreetAddress") staffStreetAddress: String,
                    @RequestParam(value = "staffCity") staffCity: String,
                    @RequestParam(value = "staffState") staffState: String,
                    @RequestParam(value = "staffZipcode") staffZipcode: String,
                    @RequestParam(value = "staffPhoneNumber") staffPhoneNumber: String,
                    @RequestParam(value = "staffEmail") staffEmail: String,
                    @RequestParam(value = "socialSecurityNumber") socialSecurityNumber: String,
                    @RequestParam(value = "staffDateOfBirth") staffDateOfBirth: String,
                    @RequestParam(value = "staffGender") staffGender: String) : String {
        val timestamp = SimpleDateFormat("dd-MM-yyyy").parse(staffDateOfBirth).time
        val newStaff = Staff(
                staffName = staffName,
                staffStreetAddress = staffStreetAddress,
                staffCity = staffCity,
                staffState = staffState,
                staffZipcode = staffZipcode,
                staffPhoneNumber = staffPhoneNumber,
                staffEmail = staffEmail,
                socialSecurityNumber = socialSecurityNumber,
                staffDateOfBirth = Date(timestamp),
                staffGender = when(staffGender) {
                    "M" -> { 'M'}
                    "F" -> { 'F'}
                    else -> 'M'
                }
        )
        staffRepository.save(newStaff)

        return "/"
    }

}