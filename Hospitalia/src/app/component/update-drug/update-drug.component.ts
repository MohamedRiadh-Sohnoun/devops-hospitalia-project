import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DrugService } from 'src/app/service/drugservice/drug.service';
import { Drug } from 'src/app/entity/drug/drug';


@Component({
  selector: 'app-update-drug',
  templateUrl: './update-drug.component.html',
  styleUrls: ['./update-drug.component.css']
})
export class UpdateDrugComponent implements OnInit {

  id: number;
  drug: Drug = new Drug();
  constructor(private drugService: DrugService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.drugService.getDrugById(this.id).subscribe(data => {
      this.drug = data;
    } 
    , error => console.log(error));
  }

  onSubmit() {
    this.drugService.updateDrug(this.id, this.drug).subscribe(data => { 
      this.goToDrugList();
    } 
    , error => console.log(error));

  }

  goToDrugList() {
    this.router.navigate(['/druglist']);
  }

}
