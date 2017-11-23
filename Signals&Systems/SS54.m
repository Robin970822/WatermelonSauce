%%
clear;
N = 1024;
k = [0:N];
w = 2*pi*k/N; 
H = [ones(1, 256) zeros(1,512) ones(1, 257)];
figure;
plot(w,abs(H));xlabel('w');ylabel('|H(jw)|');
%%
clear;
N = 9;
k = [0:N-1];
w = 2*pi*k/N;
Hm(w < pi/2 ) = 1;
Hm(w > 3*pi/2 ) = 1;
figure;
plot(w, Hm);