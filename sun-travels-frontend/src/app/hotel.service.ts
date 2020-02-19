import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private webRequestService: WebRequestService) { }

  getAllHotels() {
    return this.webRequestService.get('hotel');
  }
}
