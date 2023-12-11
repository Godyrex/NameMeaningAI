// story.component.ts

import { Component } from '@angular/core';
import { StoryService } from '../story.service';
import { Router } from '@angular/router'; // Import Router


@Component({
  selector: 'app-story',
  templateUrl:'./story.component.html',
})
export class StoryComponent {
  name: string = '';
  responseMessage: string = ''; // New property to store the response message

  constructor(private storyService: StoryService, private router: Router) {}

  saveNamee() {
    this.storyService.saveName(this.name).subscribe({
      next: response => {
        if (response.name) {
          this.responseMessage = `Name saved successfully: ${response.name} ,`+ JSON.stringify(response);
          this.router.navigate([`/story/${response.idStory}`]);
        } else {
          this.responseMessage = 'Name saved successfully, but the returned name is empty ;'+ JSON.stringify(response);
        }
      },
      error: error => {
        this.responseMessage = 'Error saving name: ' + JSON.stringify(error);
      }
    });
  }
}
