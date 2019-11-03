package com.shafaseyo.hmjpolines;

import java.util.ArrayList;

public class HmjData {

    public static String [][] data = new String[][] {
            {"0", "HMJ Elektro", "Himpunan Mahasiswa Jurusan Teknik Elektro adalah salah satu HimpunanMahasiswa Jurusan yang ada di Politeknik Negeri Semarang yang merupakanorganisasi kemahasiswaan di tingkat jurusan, yang dibentuk olehmahasiswa Jurusan Teknik Elektro untuk melaksanakan kegiatan Tri Dharma Perguruan Tinggi.", "https://i.postimg.cc/QxdcLRBk/hme.jpg"},
            {"1", "HMJ Sipil", "Himpunan Mahasiswa Jurusan Teknik Sipil adalah salah satu HimpunanMahasiswa Jurusan yang ada di Politeknik Negeri Semarang yang merupakanorganisasi kemahasiswaan di tingkat jurusan, yang dibentuk oleh mahasiswaJurusan Teknik Sipil untuk melaksanakan kegiatan Tri Dharma Perguruan Tinggi.", "https://i.postimg.cc/yxBXSxYw/hms.jpg"},
            {"2", "HMJ Mesin", "Himpunan Mahasiswa Elektro Terdiri dari 5 Program Studi yiatu D3 Teknik Informatika, D3 Teknik Elektronika, D3 Teknik Listrik, D3 Teknik Telekomunikasi, S.Tr Teknik Telekomunikasi", "https://i.postimg.cc/LsL1BS7R/hmm.jpg"},
            {"3", "HMJ Akutansi", "Himpunan Mahasiswa Elektro Terdiri dari 5 Program Studi yiatu D3 Teknik Informatika, D3 Teknik Elektronika, D3 Teknik Listrik, D3 Teknik Telekomunikasi, S.Tr Teknik Telekomunikasi", "https://i.postimg.cc/3NS4Jxyj/hmak.jpg"},
            {"4", "HMJ Administrasi Bisnis", "Himpunan Mahasiswa Elektro Terdiri dari 5 Program Studi yiatu D3 Teknik Informatika, D3 Teknik Elektronika, D3 Teknik Listrik, D3 Teknik Telekomunikasi, S.Tr Teknik Telekomunikasi", "https://i.postimg.cc/pLYvD1Z4/hmab.jpg"},
    };

    public static ArrayList<Hmj> getListData(){
        ArrayList<Hmj> list = new ArrayList<>();
        for (String[] aData : data){
            Hmj hmj = new Hmj();
            hmj.setId(Integer.parseInt(aData[0]));
            hmj.setName(aData[1]);
            hmj.setDescription(aData[2]);
            hmj.setPhoto(aData[3]);

            list.add(hmj);
        }
        return list;
    }
}
