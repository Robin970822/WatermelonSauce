%%
clear;
T = 1/2;
n = [-8:8];
ts = n*T;
xs1 = cos(8*pi*ts/5);
xs2(abs(ts)>2) = 0;
xs2(abs(ts)<=2) = 1-abs(ts(abs(ts)<=2))/2;
figure;
subplot(2,1,1);
stem(ts,xs1);xlabel('ts');ylabel('xs1');
subplot(2,1,2);
stem(ts,xs2);xlabel('ts');ylabel('xs2');
%%
Ti = 1/8;
omegaS = 2*pi/Ti;
ti = [-2:Ti:2];
hb1 = sin(omegaS*ti/2)./(omegaS*ti/2);
hlin = 1-abs(ti)/Ti;
figure;
subplot(2,1,1);
plot(ti,hb1);xlabel('ti');ylabel('hb1');
subplot(2,1,2);
plot(ti,hlin);xlabel('ti');ylabel('hlin');