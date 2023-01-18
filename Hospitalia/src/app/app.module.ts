import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsfeedComponent } from './component/newsfeed/newsfeed.component';
import { DocloginComponent } from './component/doclogin/doclogin.component';
import { AdminloginComponent } from './component/adminlogin/adminlogin.component';
import { DocdashComponent } from './component/docdash/docdash.component';
import { AdmindashComponent } from './component/admindash/admindash.component';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AuthGaurdService } from './service/authservice/auth-gaurd.service';
import { CreatepatientComponent } from './component/createpatient/createpatient.component';
import { UpdatePatientComponent } from './component/update-patient/update-patient.component';
import { DrugListComponent } from './component/drug-list/drug-list.component';
import { CreatedrugComponent } from './component/createdrug/createdrug.component';
import { UpdateDrugComponent } from './component/update-drug/update-drug.component';
import { AppointmentListComponent } from './component/appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './component/create-appointment/create-appointment.component';
import { ViewPatientComponent } from './component/view-patient/view-patient.component';

const routes: Routes = [
  { path: 'admindash', component: AdmindashComponent, canActivate: [AuthGaurdService] },
  { path: 'doclogin', component: DocloginComponent },
  { path: 'adlogin', component: AdminloginComponent },
  { path: 'home', component: NewsfeedComponent },
  { path: 'createpatient', component: CreatepatientComponent, canActivate: [AuthGaurdService] },
  { path: 'docdash', component: DocdashComponent, canActivate: [AuthGaurdService] },
  { path: 'updatepatient/:id', component: UpdatePatientComponent, canActivate: [AuthGaurdService] },
  { path: 'druglist', component: DrugListComponent, canActivate: [AuthGaurdService] },
  { path: 'createdrug', component: CreatedrugComponent, canActivate: [AuthGaurdService] },
  { path: 'updatedrug/:id', component: UpdateDrugComponent, canActivate: [AuthGaurdService] },
  { path: 'appointmentlist', component: AppointmentListComponent, canActivate: [AuthGaurdService] },
  { path: 'createappointment', component: CreateAppointmentComponent, canActivate: [AuthGaurdService] },
  { path: 'viewpatient/:id', component: ViewPatientComponent },
  { path: '', component: NewsfeedComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    NewsfeedComponent,
    DocloginComponent,
    AdminloginComponent,
    DocdashComponent,
    AdmindashComponent,
    CreatepatientComponent,
    UpdatePatientComponent,
    DrugListComponent,
    CreatedrugComponent,
    UpdateDrugComponent,
    AppointmentListComponent,
    CreateAppointmentComponent,
    ViewPatientComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserModule,
    Ng2SearchPipeModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
