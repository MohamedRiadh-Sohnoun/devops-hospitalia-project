import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Drug } from 'src/app/entity/drug/drug';
import { DrugService } from 'src/app/service/drugservice/drug.service';


@Component({
  selector: 'app-createdrug',
  templateUrl: './createdrug.component.html',
  styleUrls: ['./createdrug.component.css']
})
export class CreatedrugComponent implements OnInit {

  drug: Drug = new Drug();
  constructor(private drugService: DrugService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveDrug() {
    this.drugService.createDrug(this.drug).subscribe(data => {
      console.log(data);
      this.goToDrugList();
    }, 
    error => console.log(error));
  }

  goToDrugList() {

    this.router.navigate(['/druglist']);

  }

  onSubmit() {
    
    console.log(this.drug);
    this.saveDrug();
  }

}
