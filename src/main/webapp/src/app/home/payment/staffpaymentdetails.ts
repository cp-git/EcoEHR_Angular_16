export class StaffPaymentDetails{
    constructor(
        public paymentDetailsId :  number,
        public staffId : number,
        public paymentStatus: string,
        public licenseStartDate : Date,
        public licenseEndDate: Date
    )
    {}
}