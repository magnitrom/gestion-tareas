import * as crypto from 'crypto-js';
import { environment } from 'src/enviroment/environment';

export const encriptar = (value: string) => {
    const key = CryptoJS.enc.Utf8.parse(environment.crypteKey); // 16 bytes key
    const initVector = CryptoJS.enc.Utf8.parse(environment.cryptoInitVector); // 16 bytes IV

    const encrypted = CryptoJS.AES.encrypt(value, key, {
        iv: initVector,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });

    return encrypted.toString();
}

export const desenriptar = (encrypted: string) => {
    const key = CryptoJS.enc.Utf8.parse(environment.crypteKey); // 16 bytes key
    const initVector = CryptoJS.enc.Utf8.parse(environment.cryptoInitVector); // 16 bytes IV

    const decrypted = CryptoJS.AES.decrypt(encrypted, key, {
        iv: initVector,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });

    return decrypted.toString(CryptoJS.enc.Utf8);
}
