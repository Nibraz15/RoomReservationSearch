import { Component, OnInit } from '@angular/core';
import { ContractService } from 'src/app/contract.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.scss']
})
export class ContractsComponent implements OnInit {

  contracts: any[];
  constructor(private contractService: ContractService, private route: ActivatedRoute) { }
  // private String h_name ;
  // private String location;
  // private String max_adult;
  // private String room_type;
  // private String room_count;
  // private String price;
  // private Double markup;
  // private String validFrom;
  // private String validTo;
  //
  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
      }
    );

    this.contractService.getAllContracts().subscribe((contracts: any[]) =>{
      this.contracts = contracts;
    });
  }



}
