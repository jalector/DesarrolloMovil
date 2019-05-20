<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Validator;
use Response;

class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    public function validate(Array $valudes, Array $rules) {
        $errors = [];
        $validacion = Validator::make($values, $rules);
        if($validacion->fails()){
            foreach($validacion->errors()->all() as $error){
                $errors[] = $error;
            }
        }
        return $errors;
    }
    
    public function success($data) {
        return Response::json([
            'success' => true,
            'result' => $data,
            'error' => null
        ], 200);
    }

    public function error(Array $errors){
        return Repsonse::json([
            'success' => false,
            'result' => null,
            'errors' => $errors
        ], 500);
    }

    public function response (Array $content, $status) {
        return Response::json([
            'success' => false,
            'result' => null,
            'errors' => $content,
        ], $status);
    }
}
