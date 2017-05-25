import { Injectable } from '@angular/core';
import { Router, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';

import { Opera } from '../model/opera';
import { OperaService } from './opera.service';

@Injectable()
export class OperaDetailResolver implements Resolve<Opera>{

    constructor(private operaService: OperaService, private router: Router){}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Opera>{        
        let id = route.params['id'];

        console.log(`ehi I'm the resolver and I've been called, looking for opera: ${id}`);
        return this.operaService.getOpera(id).then( opera => {
            if(opera){
                return opera;
            }else{
                this.router.navigate(['/operas']);
                return null;
            }
        });
    }
}