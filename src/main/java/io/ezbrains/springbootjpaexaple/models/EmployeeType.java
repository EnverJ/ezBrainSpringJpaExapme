package io.ezbrains.springbootjpaexaple.models;

public enum EmployeeType {
    PAYROLL_EXEMPT,
    FULL_TIME,
    CONTRACTOR
}

//summary :
//
//with the enums, need to be a bit careful.
//enums can either be stored in the database as strings or integers.
//in both the cases, if you makes changes to your enum class later.
//example changing the order of your enums, then new entries to your databse will mess up the entire table/ the old entries in the table
//example in an enum order if it changes from 0, 1 , 2 to 3, 2, 1
//and if your table is set to update
//then your new entry in the table will have  if it has the the enum value 1, it will nmean something different to what it means for the previous entries.