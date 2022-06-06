package uz.ubtuit.bookingapp.model

class AllUsers{
    var number: String? = null
    var date: String? = null
    var time: String? = null

    constructor(number: String?, date: String?, time: String?) {
        this.number = number
        this.date = date
        this.time = time
    }

    constructor()

}
