import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'ehr-plugin',
    templateUrl: 'plugin.component.html',
    styleUrls: ['plugin.component.css']
})

export class PluginComponent {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  myFun(){
    if(this.router.url == "/patients/newpatient")
    {
      var element = document.getElementById("mainCardHeader");
      if (element !== null) {
          element.scrollIntoView({  inline: "start"});
    }
  }
  }
}