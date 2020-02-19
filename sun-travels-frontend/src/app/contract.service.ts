import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private webRequestService: WebRequestService) { }

  createContract(name: string, location: string, maxadult: string, roomtype: string, roomcount: string, price: string, markup: number, validFrom: string, validTo: string ){
    return this.webRequestService.post('contract', {h_name:name, location:location, max_adult:maxadult, room_type:roomtype,  room_count:roomcount, price:price,
      markup:markup, validFrom:validFrom, validTo:validTo });
  }

  getAllContracts() {
    return this.webRequestService.get('contract');
  }
}
