
import {Organization} from '../../Organization/Organization'

export class PatientDetails {
    constructor(
        public patientId: number,
        public patientImage: Blob,
        public firstName: string,
        public middleName: string,
        public lastName: string,
        public mrn: string,
        public gender: string,
        public title: string,
        public dob: Date,
        public activeFlag: any,
        public primaryEmail: string,
        public secondaryEmail: string,
        public primaryNo: string,
        public secondaryNo: string,
        public patientStreetAddress: string,
        public patientApartmentNo: string,
        public patientCity: string,
        public patientState: string,
        public zipCode: string,
        public staffId: number,
        public organizationId: number,
        public clinicLocationId: number,
        public emrId: string,
        public additionalInfo: string,
        public createdDate: Date,
        public createdBy: string,
        public lastUpdatedDate: Date,
        public lastUpdatedBy: string,
        public  pInsName:string,
        public  pInsRelationship:string,
        public sInsRelationship: string,
        public  sInsName: string,
        public pInsCompany : string,
        public  sInsCompany: string,
        public  pInsPlanName:string,
        public  sInsPlanName:string,
        public  pInsId:string,
        public  sInsId:string,
        public  pInsGroup:string,
        public  sInsGroup:string,
        public  pInsDob:Date,
        public  sInsDob:Date,
        public  pInsSsn:string,
        public  sInsSsn:string,
        public  pInsEmployer:string,
        public  sInsEmployer:string,
        public licenseNo:string,
        public ssn:string,
        public age: string,
        public buildingNo:string,
        public race:string,
        public ethnicity:string,
        public patientLanguage:string
       
      
       
       

       
        
    ) { }
} 