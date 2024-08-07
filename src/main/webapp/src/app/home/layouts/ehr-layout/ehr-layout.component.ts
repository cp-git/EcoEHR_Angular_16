import { Component, OnInit, OnDestroy, ViewChild, HostListener, AfterViewInit } from '@angular/core';
import { Router, NavigationEnd, NavigationStart, Event } from '@angular/router';
import { NavItem, NavItemType } from '../../../shared/md/md.module';
import { Subscription } from 'rxjs';
import { Location, PopStateEvent } from '@angular/common';
import { filter } from 'rxjs/operators';
import { NavbarComponent } from '../../../components/navbar/navbar.component';

declare const $: any;

@Component({
  selector: 'ehr-main',
  templateUrl: './ehr-layout.component.html',
  styleUrls: [ '../../../app.component.css'],
})

export class EHRLayoutComponent implements OnInit, AfterViewInit {
  public navItems!: NavItem[];
  private _routerSubscription!: Subscription;
  private lastPoppedUrl: string = '';
  private yScrollStack: number[] = [];
  url!: string;
  location: Location;

  @ViewChild('sidebar') sidebar: any;
  @ViewChild(NavbarComponent)
  navbar!: NavbarComponent;

  constructor(private router: Router, location: Location) {
    this.location = location;
  }

  ngOnInit() {
    const elemMainPanel = document.querySelector('.main-panel') as HTMLElement;
    const elemSidebar = document.querySelector('.sidebar .sidebar-wrapper') as HTMLElement;

    this.location.subscribe((ev: PopStateEvent) => {
      this.lastPoppedUrl = ev.url ?? '';
    });

    this.router.events.subscribe((event: Event) => {
      if (event instanceof NavigationStart) {
        if (event.url !== this.lastPoppedUrl) {
          this.yScrollStack.push(window.scrollY);
        }
      } else if (event instanceof NavigationEnd) {
        if (event.url === this.lastPoppedUrl) {
          this.lastPoppedUrl = '';
          window.scrollTo(0, this.yScrollStack.pop() as number);
        } else {
          window.scrollTo(0, 0);
        }
      }
    });

    this._routerSubscription = this.router.events
      .pipe(filter((event): event is NavigationEnd => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        elemMainPanel.scrollTop = 0;
        elemSidebar.scrollTop = 0;
      });

    if (window.matchMedia('(min-width: 960px)').matches && !this.isMac()) {
      // Initialize PerfectScrollbar if necessary
      // let ps1 = new PerfectScrollbar(elemMainPanel);
      // ps1.update();
      // let ps2 = new PerfectScrollbar(elemSidebar);
      // ps2.update();
    }

    this._routerSubscription = this.router.events
      .pipe(filter((event): event is NavigationEnd => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.navbar.sidebarClose();
      });

    this.navItems = [
      { type: NavItemType.NavbarLeft, title: 'Dashboard', iconClass: 'fa fa-dashboard' },
      {
        type: NavItemType.NavbarRight,
        title: '',
        iconClass: 'fa fa-bell-o',
        numNotifications: 5,
        dropdownItems: [
          { title: 'Notification 1' },
          { title: 'Notification 2' },
          { title: 'Notification 3' },
          { title: 'Notification 4' },
          { title: 'Another Notification' }
        ]
      },
      {
        type: NavItemType.NavbarRight,
        title: '',
        iconClass: 'fa fa-list',
        dropdownItems: [
          { iconClass: 'pe-7s-mail', title: 'Messages' },
          { iconClass: 'pe-7s-help1', title: 'Help Center' },
          { iconClass: 'pe-7s-tools', title: 'Settings' },
          'separator',
          { iconClass: 'pe-7s-lock', title: 'Lock Screen' },
          { iconClass: 'pe-7s-close-circle', title: 'Log Out' }
        ]
      },
      { type: NavItemType.NavbarLeft, title: 'Search', iconClass: 'fa fa-search' },
      { type: NavItemType.NavbarLeft, title: 'Account' },
      {
        type: NavItemType.NavbarLeft,
        title: 'Dropdown',
        dropdownItems: [
          { title: 'Action' },
          { title: 'Another action' },
          { title: 'Something' },
          { title: 'Another action' },
          { title: 'Something' },
          'separator',
          { title: 'Separated link' },
        ]
      },
      { type: NavItemType.NavbarLeft, title: 'Log out' }
    ];
  }

  ngAfterViewInit() {
    this.runOnRouteChange();
  }

  public isMap(): boolean {
    return this.location.prepareExternalUrl(this.location.path()) === '/maps/fullscreen';
  }

  runOnRouteChange(): void {
    if (window.matchMedia('(min-width: 960px)').matches && !this.isMac()) {
      const elemSidebar = document.querySelector('.sidebar .sidebar-wrapper') as HTMLElement;
      const elemMainPanel = document.querySelector('.main-panel') as HTMLElement;
      // Initialize PerfectScrollbar if necessary
      // let ps = new PerfectScrollbar(elemMainPanel);
      // ps.update();
      // let ps = new PerfectScrollbar(elemSidebar);
      // ps.update();
    }
  }

  isMac(): boolean {
    return /MAC|IPAD/i.test(navigator.platform);
  }
}
