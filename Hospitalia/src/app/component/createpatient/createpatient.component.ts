import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Drug } from 'src/app/entity/drug/drug';
import { DrugService } from 'src/app/service/drugservice/drug.service';
import { Patient } from 'src/app/entity/patient/patient';
import { PatientService } from 'src/app/service/patientservice/patient.service';

@Component({
  selector: 'app-createpatient',
  templateUrl: './createpatient.component.html',
  styleUrls: ['./createpatient.component.css']
})
export class CreatepatientComponent implements OnInit {

  patient: Patient = new Patient();
  constructor(private patientService: PatientService, private drugService: DrugService,
    private router: Router) { }

  ngOnInit(): void {
  }

  savePatient() {
    this.patientService.createPatient(this.patient).subscribe(data => this.goToPatientList());
    
  }
  goToPatientList() {
    this.router.navigate(['/docdash']);
  }

  onSubmit() {
    console.log(this.patient);
    this.savePatient();
  }

}
