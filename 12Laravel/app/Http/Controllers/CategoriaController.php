<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Categoria;

class CategoriaController extends Controller
{
    public function insertar(Request $request){
        $rules = [
            'name' => 'requiere'
        ];

        $data = $request->all();

        $errors = $this->validate($data, $rules);

        if (count($errors) > 0){
            return $this->error($errors);
        }

        $categoria = Categoria::create($data);
        return $this->success($categoria);
    }
}
