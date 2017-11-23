%%
clear;
N = 1024;
a1 = 1;
b1 = [0 0 0 1];
[H1 w1] = freqz(b1, a1, N);
figure;
subplot(2,1,1);
plot(w1,abs(H1));xlabel('w');ylabel('|H1(jw)|');
subplot(2,1,2);
plot(w1,angle(H1));xlabel('w');ylabel('angle(H1(jw))');
%%
a2 = [1 -0.75];
b2 = [-0.75 1];
[H2 w2] = freqz(b2, a2, N);
figure;
subplot(2,1,1);
plot(w2,abs(H2));xlabel('w');ylabel('|H2(jw)|');
subplot(2,1,2);
plot(w2,angle(H2));xlabel('w');ylabel('angle(H2(jw))');