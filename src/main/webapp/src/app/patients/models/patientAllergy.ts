export class PatientAllergy {
    constructor(
        public patientAllergyId:number ,
        public productName: string, 
        public form: string, 
        public route: string,
        public dose: string,
        public activeFlag: boolean,
        public medicationId: number,
        public createdDate: Date,
        public lastUpdatedDate: Date,
        public createdBy: string,
        public lastUpdatedBy: string,
        public encounterId: number,  
        public patientId: number, 
       
      
        
     
    ){}
}