package uz.ubtuit.bookingapp.model

class NewOrders {
    var number: String? = null
    var date: String? = null
    var time: String? = null
    var salon:String? = null

    constructor(number: String?, date: String?, time: String? , salon:String?) {
        this.number = number
        this.date = date
        this.time = time
    }


    constructor()

    constructor(number: String?, date: String?, time: String?) {
        this.number = number
        this.date = date
        this.time = time
    }

}
