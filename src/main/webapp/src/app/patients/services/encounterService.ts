import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable, throwError } from 'rxjs';
import { AppSettings } from '../../appsettings';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Encounter } from '../models/encounter';
import { ChiefCompliantDtl } from '../models/chiefCompliantDtl';
import { ICD10Group } from '../models/ICD10Group';
import { ICD10 } from '../models/ICD10';

import { catchError, map } from 'rxjs/operators';
import { Medication } from '../models/medication';
@Injectable()
export class EncounterService {
    addEncounterUrl = AppSettings.API_ENDPOINT + "./encounter/createEncounter";
    getAllEncounterUrl = AppSettings.API_ENDPOINT + "./encounter/getAllEncounterByPatientId";
    getallICD10GroupsUrl = AppSettings.API_ENDPOINT + "./icd10Groups/getAllICD10Groups";
    getMedicationListUrl = AppSettings.API_ENDPOINT + "./medication/getMedicationList";
    addChiefCompliantDtlUrl = AppSettings.API_ENDPOINT + "./chiefCompliantDtls/createChiefCompliant";
    getAllChiefCompliantDetailsByEncounterIdUrl = AppSettings.API_ENDPOINT + "./chiefCompliantDtls/getAllChiefCompliantByEncounterId"
    getEncounterByEncounterIdUrl = AppSettings.API_ENDPOINT + "./encounter/getEncounterByEncounterId";
    updateEncounterUrl = AppSettings.API_ENDPOINT + "./encounter/updateEncounter";
    updateCompletedEncounterUrl = AppSettings.API_ENDPOINT + "./encounter/updateCompletedEncounter";
    getIcd10DetailsOfLastFiveEncountersUrl = AppSettings.API_ENDPOINT + "./chiefCompliantDtls/getIcd10DetailsOfLastFiveEncounters";
    deleteEncounterUrl = AppSettings.API_ENDPOINT + "./encounter/deleteEncounter";
    updateEncounterRecordUrl = AppSettings.API_ENDPOINT + "./encounter/updateEncounterByEncounterID";
    updateChiefCompliantDtlUrl = AppSettings.API_ENDPOINT + "./chiefCompliantDtls/updateChiefCompliant";
    deleteChiefCompliantDtlUrl = AppSettings.API_ENDPOINT + "./chiefCompliantDtls/deleteCompliant";

    private jsonUrl = 'assets/e_m.json'; 
    

    private jsonUrl1 = 'assets/ALLICD.json'; 
    


    constructor(private http: HttpClient) {
    }

    getData(): Observable<any[]> {
        return this.http.get<any[]>(this.jsonUrl);
      }


      getDataAll(): Observable<any[]> {
        return this.http.get<any[]>(this.jsonUrl1);
      }


    search(terms: string, icdgroupVal: any): Observable<ICD10[]> {
        const val = terms.toLowerCase();  // Define val here
        return this.http.get<ICD10[]>('./assets/' + icdgroupVal + '.json').pipe(
            map(data => {
              return data.filter(d => 
                d.Description.toLowerCase().includes(val) ||
                d.SearchInclusion.toLowerCase().includes(val) ||
                d.ClinicalNotes.toLowerCase().includes(val) ||
                d.ICD10Code.toLowerCase().includes(val)
              );
            }),
            catchError(this.handleError)
          );
    }

    // getMedicationList(): Observable<Medication[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getMedicationListUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }
      
    searchAllergy(terms: string): Observable<Medication[]> {

        const normalizedTerms = (terms || '').toLowerCase();

        // Early exit if no terms provided
        if (!normalizedTerms) {
            return this.http.get<Medication[]>('./assets/Dist_MedicationAllergy.json').pipe(
                map(allAllergyData => allAllergyData), // Return all if no search terms
                catchError(this.handleError)
            );
        }

        return this.http.get<Medication[]>('./assets/Dist_MedicationAllergy.json').pipe(
            map(allAllergyData => {
                if (/\s/.test(normalizedTerms)) {
                    const val = normalizedTerms.split(" ", 2);
                    return allAllergyData.filter(d =>
                        d.activeingredient.toLowerCase().includes(val[0]) ||
                        d.drugname.toLowerCase().includes(val[0])
                    ).filter(d => 
                        d.dose.toLowerCase().includes(val[1])
                    );
                } else {
                    return allAllergyData.filter(d =>
                        d.activeingredient.toLowerCase().includes(normalizedTerms) ||
                        d.drugname.toLowerCase().includes(normalizedTerms)
                    );
                }
            }),
            catchError(this.handleError)
        );


        // if (/\s/.test(terms.toLowerCase())) {
        //     let val= terms.toLowerCase().split(" ",2);
        //    return this.http.get('./assets/Dist_MedicationAllergy.json')
        //         .map(data => {
        //             let allAllergyData: Medication[] = data.json();
        //             return allAllergyData.filter(d => d.activeingredient.toLowerCase().includes(val[0]) || d.drugname.toLowerCase().includes(val[0]))
        //             .filter(d => d.dose.toLowerCase().includes(val[1]));
        //         }).
        //         catch(this.handleError);
        // }else{
        //     let val= terms.toLowerCase();
        //     return this.http.get('./assets/Dist_MedicationAllergy.json')
        //          .map(data => {
        //              let allAllergyData: Medication[] = data.json();
        //              return allAllergyData.filter(d => d.activeingredient.toLowerCase().includes(val) || d.drugname.toLowerCase().includes(val))
                     
        //          }).
        //          catch(this.handleError);
        // }
        
    }
    
    //insert encounter
    insertEncounter(encounter: Encounter): Observable<Encounter> {

        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
		return this.http.post<any>(this.addEncounterUrl, encounter, {headers})

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let options = new RequestOptions({ headers: cpHeaders });
        // return this.http.post(this.addEncounterUrl, encounter, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // updateEncounter(encounterId: number,templateId: number,examName: string,isEdited: string): Observable<Encounter> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
    //     cpParams.set('templateId', templateId.toString());
    //     cpParams.set('examName', examName.toString());
    //     cpParams.set('isEdited', isEdited.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams  });
    //     return this.http.get(this.updateEncounterUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // updateForCompletedEncounter(encounter: Encounter): Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //    // let cpParams = new URLSearchParams();
    //     let options = new RequestOptions({ headers: cpHeaders});
    //     return this.http.put(this.updateCompletedEncounterUrl, encounter,options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // updateEncounterRecord(encounter: Encounter): Observable<number> {
    //   //  console.log("update Enc")
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //    // let cpParams = new URLSearchParams();
    //     let options = new RequestOptions({ headers: cpHeaders});
    //     return this.http.put(this.updateEncounterRecordUrl, encounter,options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }
    //get all encounters by patientId 
    getEncounterByPatientId(patientId: number): Observable<Encounter[]> {

        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		const params = new HttpParams().set('patientId', patientId.toString());
		return this.http.get<any>(this.getAllEncounterUrl,{headers, params} )

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // cpParams.set('patientId', patientId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getAllEncounterUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    getEncounterByEncounterId(encounterId: number): Observable<Encounter> {

        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('encounterId', encounterId.toString());

		return this.http.get<any>(this.getEncounterByEncounterIdUrl,{headers, params} )
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // cpParams.set('encounterId', encounterId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getEncounterByEncounterIdUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    getAllChiefCompliantDetailsByEncounterId(encounterId: number): Observable<ChiefCompliantDtl[]> {
        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('encounterId', encounterId.toString());

		return this.http.get<any>(this.getAllChiefCompliantDetailsByEncounterIdUrl,{headers, params} )
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // cpParams.set('encounterId', encounterId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getAllChiefCompliantDetailsByEncounterIdUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // //insert chief Compliant dtl
    insertChiefCompliantDtl(chiefCompliantDtl: ChiefCompliantDtl[],encounterId:number): Observable<number> {
       //console.log("insert")

       const token = localStorage.getItem('jwt') || '';
       const headers = new HttpHeaders({
           'Content-Type': 'application/json',
           'x-auth-token': token
       });
       
       
       const params = new HttpParams().set('encounterId', encounterId.toString());

       
       return this.http.post<any>(this.addChiefCompliantDtlUrl, chiefCompliantDtl, {headers,params})

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // cpParams.set('encounterId', encounterId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams  });
        // return this.http.post(this.addChiefCompliantDtlUrl, chiefCompliantDtl, options)
        //     .map(success => success.status)
        //     .catch(this.handleError);
    }

    //  //update chief Compliant dtl
    //  updatechiefCompliant(chiefCompliantDtl: ChiefCompliantDtl[],encounterId:number): Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams  });
    //     return this.http.put(this.updateChiefCompliantDtlUrl, chiefCompliantDtl, options)
    //         .map(success => success.status)
    //         .catch(this.handleError);
    // }


    // //get all icd10 groups
    getAllICD10Groups(): Observable<ICD10Group[]> {

        
        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		return this.http.get<any>(this.getallICD10GroupsUrl,{headers} )

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let options = new RequestOptions({ headers: cpHeaders });
        // return this.http.get(this.getallICD10GroupsUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // getIcd10DetailsOfLastFiveEncounters(patientId:number): Observable<ChiefCompliantDtl[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('patientId', patientId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getIcd10DetailsOfLastFiveEncountersUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // deleteEncounter(encounterId: number):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deleteEncounterUrl, options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    // }


    // deleteChiefCompliantDtl(icdCodesList: ChiefCompliantDtl[]):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let options = new RequestOptions({ headers: cpHeaders});
    //     return this.http.post(this.deleteChiefCompliantDtlUrl, icdCodesList,options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    //   }

    // private extractData(res: Response) {
    //     let body = res.json();
    //     return body;
    // }

    // private handleError(error: Response | any) {
    //     console.error(error.message || error);
    //     return Observable.throw(error.status);
    // }


    

    private handleError(error: any): Observable<never> {
        // Customize your error handling here
        console.error('An error occurred', error);
        return throwError(error);
      }

}