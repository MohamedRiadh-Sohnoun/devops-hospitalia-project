import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Drug } from '../../entity/drug/drug';
import { DrugService } from 'src/app/service/drugservice/drug.service';

@Component({
  selector: 'app-drug-list',
  templateUrl: './drug-list.component.html',
  styleUrls: ['./drug-list.component.css']
})
export class DrugListComponent implements OnInit {

  drugs: Drug[];

  constructor(private drugService: DrugService,
    private router: Router) { }

  ngOnInit(): void {

    this.getDrugs();

  }

  private getDrugs(){
    this.drugService.getDrugsList().subscribe(data => {this.drugs = data;
    });

}

updateDrug(id: number){

  this.router.navigate(['updatedrug', id]);

}

deleteDrug(id: number){
  this.drugService.deleteDrug(id).subscribe( data => { 
    console.log(data);
    this.getDrugs();
  })
}
}
