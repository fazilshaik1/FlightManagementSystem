import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { AllBookingComponent } from './all-booking/all-booking.component';
import { GetBookingComponent } from './get-booking/get-booking.component';
import { ListAirportComponent } from './list-airport/list-airport.component';
import { ListallAirportsComponent } from './listall-airports/listall-airports.component';
import { ListallFlightsComponent } from './listall-flights/listall-flights.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ListUserComponent } from './list-user/list-user.component';
import { ListallUsersComponent } from './listall-users/listall-users.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { ListallPassengersComponent } from './listall-passengers/listall-passengers.component';
import { ListPassengerComponent } from './list-passenger/list-passenger.component';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { GetScheduleComponent } from './get-schedule/get-schedule.component';
import { ListallSchedulesComponent } from './listall-schedules/listall-schedules.component';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import { GetScheduledflightComponent } from './get-scheduledflight/get-scheduledflight.component';
import { ListallScheduledflightsComponent } from './listall-scheduledflights/listall-scheduledflights.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'add-airport', component:AddAirportComponent},
  {path:'list-airport', component:ListAirportComponent},
  {path:'listall-airports', component:ListallAirportsComponent},
  {path:'add-flight', component:AddFlightComponent },
  {path:'update-flight', component:UpdateFlightComponent},
  {path:'listall-flights', component:ListallFlightsComponent},
  { path:'add-booking', component:AddBookingComponent},
  { path:'getbooking', component:GetBookingComponent},
  { path: 'allbooking', component:AllBookingComponent},
  {path:'add-user', component:AddUserComponent},
  { path:'list-user', component:ListUserComponent},
  {path:'listall-users', component:ListallUsersComponent},
  {path:'add-passenger' ,component:AddPassengerComponent},
  {path:'listall-passengers' ,component:ListallPassengersComponent},
  {path:'list-passenger', component:ListPassengerComponent},
  {path:'add-schedule',component:AddScheduleComponent},
  {path:'find-schedule',component:GetScheduleComponent},
  {path:'listall-schedules',component:ListallSchedulesComponent},
  {path:'add-scheduledflight',component:AddScheduledflightComponent},
  {path:'find-scheduledflight',component:GetScheduledflightComponent},
  {path:'listall-scheduledflights',component:ListallScheduledflightsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
