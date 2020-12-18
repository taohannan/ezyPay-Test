# ezyPay-Test

subscription type as = DAILY, WEEKLY, MOTHLY

payload to Test

{
	"fees" : 10.00,
	"subscriptionType" : "MONTHLY"

}

expected response :

{
    "fees": 10,
    "subscriptionType": "MONTHLY",
    "startDate": "2020-12-18",
    "endDate": "2021-03-18",
    "createdDate": "2020-12-18",
    "updatedDate": null,
    "invoiceDate": [
        "18/12/2020",
        "18/01/2021",
        "18/02/2021",
        "18/03/2021"
    ]
}
