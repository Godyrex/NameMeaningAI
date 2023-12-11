import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StoryService } from '../story.service';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
})
export class StoryDetailComponent implements OnInit {
  story: any; // Modify the type based on your actual story model

  constructor(
    private route: ActivatedRoute,
    private storyService: StoryService
  ) {}

  ngOnInit() {
    // Retrieve the story ID from the route parameter
    const id = this.route.snapshot.paramMap.get('id') ?? '';

    // Fetch the story details based on the ID
    this.storyService.getStoryDetails(id).subscribe((response) => {
      this.story = response;
    });
  }
}
