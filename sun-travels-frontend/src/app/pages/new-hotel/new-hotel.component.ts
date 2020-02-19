import { Component, OnInit } from '@angular/core';
import { ContractService } from 'src/app/contract.service';
import {ActivatedRoute, Params} from '@angular/router';
// tslint:disable-next-line:import-spacing
import {HotelService} from  'src/app/hotel.service';
import {MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-new-hotel',
  templateUrl: './new-hotel.component.html',
  styleUrls: ['./new-hotel.component.scss']
})
export class NewHotelComponent implements OnInit {

  hotels: any[];

  constructor(private hotelsService: HotelService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
      }
    );

    this.hotelsService.getAllHotels().subscribe((hotels: any[]) =>{
      this.hotels = hotels;
    });
  }


}
