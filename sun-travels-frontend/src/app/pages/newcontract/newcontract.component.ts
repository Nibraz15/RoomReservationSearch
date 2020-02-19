import { Component, OnInit } from '@angular/core';
import { ContractService } from 'src/app/contract.service';
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-newcontract',
  templateUrl: './newcontract.component.html',
  styleUrls: ['./newcontract.component.scss']
})
export class NewcontractComponent implements OnInit {

  constructor(private contractService: ContractService, private route: ActivatedRoute) { }


  ngOnInit(): void {
  }

  createContract(name: string, location: string, maxadult: string, roomtype: string, roomcount: string, price: string, markup: string, validFrom: string, validTo: string  ) {

    this.contractService.createContract(name, location, maxadult, roomtype, roomcount, price, parseFloat(markup) , validFrom, validTo ).subscribe((response: any) => {console.log(response)});
  }
}
