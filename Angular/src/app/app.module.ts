import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StoryComponent } from './story/story.component';
import { StoryService } from './story.service';
import { HttpClientModule } from '@angular/common/http';
import { StoryDetailComponent } from './story-detail/story-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    StoryComponent,
    StoryDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    StoryService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
