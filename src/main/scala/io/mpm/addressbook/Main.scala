package io.mpm.addressbook

import io.mpm.addressbook.domain.Gender

import scala.io.Source

/**
  * Created by Michael on 22/03/2017.
  */
object Main extends App{

  def getFile(filePath: String) = {
    val src = Source.fromFile(filePath)
    src.getLines()
  }

  //val addresses = new CSVParser("src/main/resources/AddressBook.csv").getEntries(getFile)

  val addresses = new CSVParser().getEntries("src/main/resources/AddressBook.csv")

  val addressBook = new AddressBook(addresses)

  val addressBookChecker = new AddressBookChecker(addressBook)

  println("How many males are in the address book?")

  println(addressBookChecker.findByGender(gender = Gender.Male).length)

  println("Who is the oldest person in the address book?")

  println(addressBookChecker.findOldest.name)

  println("How many days older is Bill than Paul?")

  println(addressBookChecker.getAgeDifferenceInDays("Bill", "Paul"))

}
