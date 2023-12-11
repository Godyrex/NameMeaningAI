import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoryComponent } from './story/story.component';
import { StoryDetailComponent } from './story-detail/story-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/story', pathMatch: 'full' },
  { path: 'story', component: StoryComponent },
  { path: 'story/:id', component: StoryDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
