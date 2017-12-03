%%
clc;
clear;
T=1;
w=-2*pi:2*pi;
Hd=1i*w/T;
subplot(2,1,1);
plot(w,abs(Hd));
title('幅值特性曲线');
subplot(2,1,2);
plot(w,angle(Hd));
title('相值特性曲线');
%%
clc;
clear;
n=0:255;
hd=zeros(size(n));

for m=1:255;
    hd(m)=power(-1,m)/m;
end
stem(n,hd)
%%
n = 1:511;
hd= (-1).^n./n;
w = boxcar(511);
h = w*hd;
H = fft(h,1024);
plot(abs(H));
axis([-2*pi 2*pi 0 600]);
%%
n = 1:17;
hd= (-1).^n./n;
w = boxcar(17);
h = w*hd;
H = fft(h,1024);
plot(abs(H));
axis([-2*pi 2*pi 0 25]);
%%
clc;
clear;
c=pi/10;
T=1;
t=0:100;
n=0:100;
xd=cos(c*n*T);
stem(t,xd);
title('xd[n]');
%%
clc;
clear;
c=pi/4;
T=1;
t=0:100;
n=0:100;
xd=cos(c*n*T);
figure;
stem(t,xd);
title('xd[n] c=pi/4');

clc;
clear;
c=3*pi/4;
T=1;
t=0:100;
n=0:100;
xd=cos(c*n*T);
figure;
stem(t,xd);
title('xd[n] c=3*pi/4');

clc;
clear;
c=5*pi/4;
T=1;
t=0:100;
n=0:100;
xd=cos(c*n*T);
figure;
stem(t,xd);
title('xd[n] c=5*pi/4');
