// import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from "@angular/common/http";
// import {Injectable} from "@angular/core";
// import { Observable } from "rxjs";
// import 'rxjs/add/operator/do';
    
// @Injectable()
// export class CustomInterceptor implements HttpInterceptor {
    
//   constructor() {}
    
//   intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
//     console.log("outgoing request",request);
//     request = request.clone({ withCredentials: true });
//       console.log("new outgoing request",request);
    
//       return next
//         .handle(request);
//   }
// }
