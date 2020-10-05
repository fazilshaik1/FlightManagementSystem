import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { ListallFlightsComponent } from './listall-flights/listall-flights.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { FlightService } from './service/flightservice';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { ListAirportComponent } from './list-airport/list-airport.component';
import { ListallAirportsComponent } from './listall-airports/listall-airports.component';
import { AirportService } from './service/airportservice';
import { UserService } from './service/userservice';
import { PassengerService } from './service/passengerservice';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { GetBookingComponent } from './get-booking/get-booking.component';
import { AllBookingComponent } from './all-booking/all-booking.component';
import { BookingService } from './service/bookingservice';
import { AddUserComponent } from './add-user/add-user.component';
import { ListallUsersComponent } from './listall-users/listall-users.component';
import { ListUserComponent } from './list-user/list-user.component';
import { AddPassengerComponent } from './add-passenger/add-passenger.component';
import { ListallPassengersComponent } from './listall-passengers/listall-passengers.component';
import { ListPassengerComponent } from './list-passenger/list-passenger.component';
import { ScheduleService } from './service/scheduleservice';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { GetScheduleComponent } from './get-schedule/get-schedule.component';
import { ListallSchedulesComponent } from './listall-schedules/listall-schedules.component';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import { GetScheduledflightComponent } from './get-scheduledflight/get-scheduledflight.component';
import { ListallScheduledflightsComponent } from './listall-scheduledflights/listall-scheduledflights.component';
import { ScheduledFlightService } from './service/scheduledflightservice';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    AddFlightComponent,
    ListallFlightsComponent,
    UpdateFlightComponent,
    AddAirportComponent,
    ListAirportComponent,
    ListallAirportsComponent,
    AddBookingComponent,
    GetBookingComponent,
    AllBookingComponent,
    AddUserComponent,
    ListallUsersComponent,
    ListUserComponent,
    AddPassengerComponent,
    ListallPassengersComponent,
    ListPassengerComponent,
    AddScheduleComponent,
    GetScheduleComponent,
    ListallSchedulesComponent,
    AddScheduledflightComponent,
    GetScheduledflightComponent,
    ListallScheduledflightsComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [FlightService,HttpClient,AirportService,BookingService,UserService,PassengerService,ScheduleService,ScheduledFlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
