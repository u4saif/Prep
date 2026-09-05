import { Component, computed, OnInit, signal } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  count = signal(0);
  computedId = computed(() => {
    console.log();
    return `${Number((Math.random() * 100).toPrecision(2))}-${this.count() * 2}`;
  });
  buttonHandler(actionType:string){
    switch(actionType){
      case 'Add':
        this.count.update(state=>state+1);
        break;
      case 'Sub':
        this.count.update(state=>state-1);
        break;  
      default:
    }

  }
  ngOnInit(): void {
  }

}
