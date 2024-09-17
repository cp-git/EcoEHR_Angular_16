export class EncAsessment {
    constructor(
      
        public encAsessmentId: number, 
        public encounterId: number,
        public patientId: number,
        public icd10Code: string,
        public icd10CodeDescription: string,
        public createdBy: string,
        public createdDate: Date,
        public lastUpdatedBy: string,
        public lastUpdatedDate: Date,
        public activeFlag: any
       
    ){}
}