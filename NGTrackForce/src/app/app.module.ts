///
//  DEPENDENCIES
///

import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule, JsonpModule } from '@angular/http';
import { ChartsModule } from 'ng2-charts';


///
//  COMPONENTS
///

import { AppComponent } from './app.component';
import { AssociateListComponent } from './components/associate-list/associate-list.component';
import { BatchListComponent } from './components/batch-list/batch-list.component';
import { ClientMappedComponent } from './components/client-mapped/client-mapped.component';
import { CreateUserComponent } from './components/create-user/create-user.component';
import { LoginComponent } from './components/login/login.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';

///
//  SERVICES
///
import { RequestService } from './services/request.service';

import { AssociateService } from './services/associates-service/associates-service';
import { ClientListService } from './services/client-list-service/client-list.service';
import { ClientMappedService } from './services/client-mapped-service/client-mapped-service.service';
import { AuthenticationService } from './services/authentication/authentication.service';

///
//  CONSTANTS
///

import { appRoutes } from './routing/routes';
import { SearchFilterPipe } from './pipes/search-filter/search-filter.pipe';
import { SkillsetComponent } from './components/skillset/skillset.component';
import { RootComponent } from './components/root/root.component';




@NgModule({
  declarations: [
    AppComponent,
    SkillsetComponent,
    NavbarComponent,
    HomeComponent,
    AssociateListComponent,
    BatchListComponent,
    ClientMappedComponent,
    ClientListComponent,
    LoginComponent,
    CreateUserComponent,
    SearchFilterPipe,
    RootComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule
  ],
  providers: [AssociateService, ClientListService, ClientMappedService, AuthenticationService, RequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
