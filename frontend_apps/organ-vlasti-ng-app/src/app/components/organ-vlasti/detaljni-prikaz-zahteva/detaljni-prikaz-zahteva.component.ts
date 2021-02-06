import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IzjasnjavanjeDialogComponent} from '../izjasnjavanja/izjasnjavanje-dialog/izjasnjavanje-dialog.component';
import {DialogOdbijanjeComponent} from './dialog-odbijanje/dialog-odbijanje.component';
import {MatDialog} from '@angular/material/dialog';
import {ZahtevService} from "../../../services/zahtev-service/zahtev.service";
import {ObavestenjeService} from "../../../services/obavestenje-service/obavestenje.service";

@Component({
  selector: 'app-detaljni-prikaz-zahteva',
  templateUrl: './detaljni-prikaz-zahteva.component.html',
  styleUrls: ['./detaljni-prikaz-zahteva.component.css']
})
export class DetaljniPrikazZahtevaComponent implements OnInit {

  zahtevId = '0';
  odbijen = false;
  neobradjena = true;
  src = '';
  obavestenje = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router, public dialog: MatDialog, private service: ZahtevService
              , private obavestenjeService: ObavestenjeService) { }


  ngOnInit(): void {
    this.zahtevId = this.activatedRoute.snapshot.queryParamMap.get('zahtev_id');
    const status = this.activatedRoute.snapshot.queryParamMap.get('zahtev_status');
    this.service.convertZahtevXHTML(this.zahtevId).subscribe( res => {
      const binaryData = [];
      binaryData.push(res);
      const url = window.URL.createObjectURL(new Blob(binaryData, {type: 'text/html'}));
      this.src = url;
    });
    if (status === 'odbijen' || status === 'prihvacen'){
      this.odbijen = true;
    }
    if (status === 'neobradjen') {
      this.neobradjena = true;
    }
    this.obavestenjeService.getObavestenjeByZahtev(this.zahtevId).subscribe( res => {
      if (res){
        // @ts-ignore
        const convert = require('xml-js');
        const obavestenje = JSON.parse(convert.xml2json(res, {compact: true, spaces: 4}));
        this.obavestenje = obavestenje['oba:obavestenje']['oba:obavestenje_body']._attributes.id;
      }
    });

    this.obavestenjeService.getObavestenjeByZahtev(this.zahtevId).subscribe( res => {
      if (res){
        // @ts-ignore
        const convert = require('xml-js');
        const obavestenje = JSON.parse(convert.xml2json(res, {compact: true, spaces: 4}));
        this.obavestenje = obavestenje['oba:obavestenje']['oba:obavestenje_body']._attributes.id;
      }
    });
  }


  kreirajObavestenje($event: MouseEvent): void {
    this.router.navigate(['/obavestenje'], {queryParams: {zahtev_id: this.zahtevId}});
  }

  openDialog($event: MouseEvent) {
    const dialogRef = this.dialog.open(DialogOdbijanjeComponent, {
      width: '250px',
      data: {zahtevId: this.zahtevId}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.router.navigate(['/pocetna-stranica-organ-vlasti']);
    });
  }

  obavestenjeDetails() {
    this.router.navigate(['/detaljni-prikaz-obavestenja'], {queryParams: {broj: this.obavestenje}});
  }
}
