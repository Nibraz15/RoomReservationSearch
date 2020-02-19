import { Component, OnInit } from '@angular/core';
import {RoomSeviceService} from 'src/app/room-sevice.service';

import {ActivatedRoute, Params} from "@angular/router";
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  constructor(private roomSeviceService: RoomSeviceService, private route: ActivatedRoute) { }
  Rooms: any[];
  ngOnInit(): void {
  }
  searchRoom(bookFrom: string, bookTo: string, numRoom: string, numAdult: string ){
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
      }
    );

    this.roomSeviceService.searcRoom(bookFrom, bookTo, numRoom, numAdult).subscribe((Rooms: any[]) =>{
      this.Rooms = Rooms;
    });
  }

  reload(){
    location.reload();
  }

}
