import { Inject, Injectable } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Injectable()
export class JsUtils {

    constructor(@Inject(DOCUMENT) private document: Document) {}
    
    public loadScript(scritptName: string) {
        const node = this.document.createElement('script');
        node.src = scritptName;
        node.type = 'text/javascript';
        node.async = true;
        node.charset = 'utf-8';
        this.document.getElementsByTagName('head')[0].appendChild(node);
    }

    public loadAllChartScript() {
        this.loadScript('../assets/vendor/chart.js/Chart.js');
        setTimeout(() => {
            this.loadScript('../assets/js/demo/chart-area-demo.js');
        }, 400);
        setTimeout(() => {
            this.loadScript('../assets/js/demo/chart-pie-demo.js');
        }, 400);
    }
}

