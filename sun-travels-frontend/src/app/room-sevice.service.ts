import { Injectable } from '@angular/core';
import {WebRequestService} from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class RoomSeviceService {

  constructor(private webRequestService: WebRequestService) { }

  searcRoom(bookFrom: string, bookTo: string, numRoom: string, numAdult: string ){
    // tslint:disable-next-line:radix max-line-length
    return this.webRequestService.post('rooms', {bookFrom: bookFrom, bookTo :bookTo, numRoom: parseInt(numRoom), numAdult: parseInt(numAdult)});
  }
}
