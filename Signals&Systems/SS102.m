%%
clear;
b1 = 1;
a1 = [1 -0.9 0.81];
ps1 = roots(a1);
dpzplot(b1,a1);
%%
omega = [0:511]*pi/256;
unitcirc = exp(j*omega);
polevectors1 = ones(2,1)*unitcirc-ps1*ones(1,512);
polelength1 = abs(polevectors1);
poleangle1 = atan2(imag(polevectors1),real(polevectors1));
%%
zerovectors1 = ones(2,1)*unitcirc;
zerolength1 = abs(zerovectors1);
zeroangle1 = atan2(imag(zerovectors1),real(zerovectors1));
%%
figure;
subplot(2,1,1);
plot(omega,polelength1);xlabel('w');ylabel('polelength1');
axis([0 2*pi -1 2]);
grid;
subplot(2,1,2);
plot(omega,zerolength1);xlabel('w');ylabel('polelength1');
axis([0 2*pi -1 2]);
grid;
%%
geomH1mag = prod(zerolength1)./prod(polelength1);
geomH1phase = sum(zeroangle1)-sum(poleangle1);
figure;
subplot(2,1,1);
plot(omega,geomH1mag);xlabel('w');ylabel('geomH1mag');
subplot(2,1,2);
plot(omega,geomH1phase);xlabel('w');ylabel('geomH1phase');

H1 = freqz(b1,a1,512,'whole');
figure;
subplot(2,1,1);
plot(omega,abs(H1));xlabel('w');ylabel('|H1(e^jw)|');
subplot(2,1,2);
plot(omega,angle(H1));xlabel('w');ylabel('<H1(e^jw)');